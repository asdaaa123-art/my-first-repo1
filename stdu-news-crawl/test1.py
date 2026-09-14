from playwright.sync_api import sync_playwright
import requests
from bs4 import BeautifulSoup
from concurrent.futures import ThreadPoolExecutor, as_completed
import urllib3
# 关闭ssl不安全警告
urllib3.disable_warnings(urllib3.exceptions.InsecureRequestWarning)

# 请求头模拟浏览器
headers = {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"
}

hrefs = []
with sync_playwright() as p:
    base_url = "https://xcbnew.stdu.edu.cn/news"
    browser = p.chromium.launch(headless=False)
    page = browser.new_page()
    page.goto(base_url, timeout=60000)

    for i in range(3):  # 爬取的页面数（以3页为例）
        links = page.locator('td[headers="categorylist_header_title"].list-title a').all()
        href = [link.get_attribute("href") for link in links if link.get_attribute("href")]
        hrefs.extend(href)
        page.get_by_label("转到第 下一页 页").first.click()
    # 移到循环外面，全部页面爬完再关闭浏览器
    browser.close()

print("抓取到的链接列表：", hrefs)

def fetch_news_content(info):
    url = f'https://xcbnew.stdu.edu.cn/{info}'
    # 增加 verify=False + headers
    response = requests.get(url, verify=False, headers=headers)
    response.encoding = 'utf-8'
    soup = BeautifulSoup(response.text, 'html.parser')

    title = soup.find("h2", itemprop="headline").get_text(strip=True)
    time = soup.find("time", itemprop="datePublished").get_text(strip=True)
    div_content = soup.find('div', itemprop='articleBody')
    text_content = div_content.get_text(strip=True)

    return title, time, text_content

# 并发调低，不要20
with ThreadPoolExecutor(max_workers=4) as executor:
    futures = [executor.submit(fetch_news_content, item) for item in hrefs]
    for future in as_completed(futures):
        try:
            title, pub_time, content = future.result()
            print("="*60)
            print(f"标题：{title}")
            print(f"发布时间：{pub_time}")
            print(f"正文预览：{content[:200]}...")
        except Exception as e:
            print("抓取失败：", e)
