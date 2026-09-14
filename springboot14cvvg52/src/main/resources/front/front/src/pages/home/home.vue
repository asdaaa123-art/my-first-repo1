<template>
	<div class="home-preview">



		<!-- 关于我们 -->
		<div id="about" class="animate__animated">
			<div class="about_item">
				<div class="about_title_box">
					<div class="about_title">{{aboutUsDetail.title}}</div>
					<div class="about_subtitle">{{aboutUsDetail.subtitle}}</div>
				</div>
				<div class="about_img">
					<img :src="baseUrl + aboutUsDetail.picture1">
					<img :src="baseUrl + aboutUsDetail.picture2">
					<img :src="baseUrl + aboutUsDetail.picture3">
				</div>
				<div class="about_content ql-snow ql-editor" v-html="aboutUsDetail.content"></div>
				<div class="about_idea1" />
				<div class="about_idea2" />
				<div class="about_idea3" />
				<div class="about_idea4" />
				<div class="about_more" @click="toDetail('aboutusDetail',aboutUsDetail)">
					<span>查看更多</span>
					<span class="icon iconfont icon-gengduo1"></span>
				</div>
			</div>
		</div>
		<!-- 关于我们 -->

		<!-- 系统简介 -->
		<div id="system" class="animate__animated">
			<div class="system_item">
				<div class="system_title_box">
					<div class="system_title">{{systemIntroductionDetail.title}}</div>
					<div class="system_subtitle">{{systemIntroductionDetail.subtitle}}</div>
				</div>
				<div class="system_img">
					<img :src="baseUrl + systemIntroductionDetail.picture1">
					<img :src="baseUrl + systemIntroductionDetail.picture2">
					<img :src="baseUrl + systemIntroductionDetail.picture3">
				</div>
				<div class="system_content ql-snow ql-editor" v-html="systemIntroductionDetail.content"></div>
				<div class="system_idea1" />
				<div class="system_idea2" />
				<div class="system_idea3" />
				<div class="system_idea4" />
				<div class="system_more" @click="toDetail('systemintroDetail',systemIntroductionDetail)">
					<span>查看更多</span>
					<span class="icon iconfont icon-gengduo1"></span>
				</div>
			</div>
		</div>
		<!-- 系统简介 -->
		<!-- 新闻资讯 -->
		<div id="animate_newsnews" class="news animate__animated">
			<div class="news_title_box">
				<span class="news_title">公告</span>
				<span class="news_subhead">{{'news'.toUpperCase()}}</span>
			</div>
			<div class="list list11 index-pv1">
				<div class="left_box">
					<div class="list-item" v-for="(item,index) in newsList" :key="index" v-if="index<Number(2)" @click="toDetail('newsDetail', item)">
						<div class="img"><img :src="baseUrl + item.picture" alt=""></div>
						<div class="infoBox">
							<div class="name">{{item.title}}</div>
							<div class="time">{{item.addtime}}</div>
							<div class="desc">{{ item.introduction }}</div>
						</div>
					</div>
				</div>
				<div class="right_box">
					<div class="list-item" :class="newsIndex11==index?'list-item-active':''" @click="newsTabClick11(index)"  v-for="(item,index) in newsList" :key="index" v-if="index>=Number(2)&&index<(Number(2) + Number(4))">
						<div class="name">{{item.title}}</div>
						<div class="list-item2" @click="toDetail('newsDetail', item)">
							<div class="desc">{{ item.introduction }}</div>
						</div>
					</div>
				</div>
			</div>
			<div class="moreBtn" @click="moreBtn('news')">
				<span class="text">查看更多</span>
				<i class="icon iconfont icon-gengduo1"></i>
			</div>
		</div>
		<!-- 新闻资讯 -->
	</div>
</template>

<script>
import 'animate.css'
import Swiper from "swiper";

	export default {
		//数据集合
		data() {
			return {
				baseUrl: '',
				aboutUsDetail: {},
				systemIntroductionDetail: {},
				newsList: [],


				newsIndex11: Number(2),



			}
		},
		created() {
			this.baseUrl = this.$config.baseUrl;
			this.getNewsList();
			this.getAboutUs();
			this.getSystemIntroduction();
			this.getList();
		},
		mounted() {
			window.addEventListener('scroll', this.handleScroll)
			setTimeout(()=>{
				this.handleScroll()
			},100)
			
			this.swiperChanges()
		},
		beforeDestroy() {
			window.removeEventListener('scroll', this.handleScroll)
		},
		//方法集合
		methods: {
			newsTabClick11(index){
				this.newsIndex11 = index
			},
			swiperChanges() {
				setTimeout(()=>{
				},750)
			},
			async recommendIndexClick18(index, name) {
				this['recommendIndex18' + name] = index
				await this.getList()
			},

			listIndexClick21(index, name) {
				this['listIndex21' + name] = index
				this.getList()
			},

			handleScroll() {
				let arr = [
					{id:'about',css:'animate__fadeInUp'},
					{id:'system',css:'animate__fadeInUp'},
					{id:'animate_newsnews',css:'animate__fadeInUp'},
				]
			
				for (let i in arr) {
					let doc = document.getElementById(arr[i].id)
					if (doc) {
						let top = doc.offsetTop
						let win_top = window.innerHeight + window.pageYOffset
						// console.log(top,win_top)
						if (win_top > top && doc.classList.value.indexOf(arr[i].css) < 0) {
							// console.log(doc)
							doc.classList.add(arr[i].css)
						}
					}
				}
			},
			preHttp(str) {
				return str && str.substr(0,4)=='http';
			},
			preHttp2(str) {
				return str && str.split(',w').length>1;
			},
			getAboutUs() {
				this.$http.get('aboutus/detail/1', {}).then(res => {
					if(res.data.code == 0) {
						this.aboutUsDetail = res.data.data;
					}
				})
			},
			getSystemIntroduction() {
				this.$http.get('systemintro/detail/1', {}).then(res => {
					if(res.data.code == 0) {
						this.systemIntroductionDetail = res.data.data;
					}
				})
			},
			getNewsList() {
				let data = {
					page: 1,
					limit: 7,
					sort: 'addtime',
					order: 'desc'
				}
				this.$http.get('news/list', {params: data}).then(res => {
					if (res.data.code == 0) {
						this.newsList = res.data.data.list;
					
					}
				});
			},
			getList() {
				let autoSortUrl = "";
				let data = {}
			
			},
			toDetail(path, item) {
				this.$router.push({path: '/index/' + path, query: {id: item.id}});
			},
			moreBtn(path) {
				this.$router.push({path: '/index/' + path});
			}
		}
	}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.home-preview {
		margin: 0px auto;
		flex-direction: column;
		background: #fff;
		display: flex;
		width: 100%;
		#about {
			margin: 20px 0 0;
			background: #fff;
			width: 100%;
			position: relative;
			height: 612px;
			order: 1;
			.about_item {
				padding: 0 0 0 450px;
				margin: 60px auto;
				z-index: 9;
				background: none;
				display: block;
				width: 1200px;
				flex-wrap: wrap;
				height: 480px;
				.about_title_box {
					margin: 100px 0 0;
					background: none;
					display: flex;
					width: 100%;
					align-items: center;
					.about_title {
						margin: 0 20px 0 0;
						color: #000;
						width: auto;
						font-size: 40px;
						line-height: 1.5;
					}
					.about_subtitle {
						margin: 0;
						color: #666;
						width: auto;
						font-size: 24px;
						line-height: 1.5;
					}
				}
				.about_img {
					padding: 0;
					display: flex;
					width: 100%;
					flex-wrap: wrap;
					height: auto;
					img:nth-child(1) {
						margin: 0;
						z-index: -2;
						top: 0;
						left: 0;
						object-fit: cover;
						display: block;
						width: 50%;
						position: absolute;
						height: 100%;
					}
					img:nth-child(2) {
						margin: 0 10px;
						flex: 1;
						object-fit: cover;
						display: none;
						height: 120px;
					}
					img:nth-child(3) {
						margin: 0 10px;
						flex: 1;
						object-fit: cover;
						display: none;
						height: 120px;
					}
				}
				.about_content {
					padding: 0;
					margin: 20px 0 10px 0;
					overflow: hidden;
					color: #333;
					background: none;
					width: 100%;
					font-size: 16px;
					line-height: 30px;
					height: 240px;
				}
				.about_idea1 {
					z-index: -1;
					top: 0;
					background: url(http://codegen.caihongy.cn/20240809/4c886953e8824f4fbce50991f268e35d.png) no-repeat center top / cover;
					display: block;
					width: 100%;
					position: absolute;
					right: 0;
					height: 100%;
				}
				.about_idea2 {
					background: url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat;
					display: none;
					width: 285px;
					height: 100px;
				}
				.about_idea3 {
					background: url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat;
					display: none;
					width: 285px;
					height: 100px;
				}
				.about_idea4 {
					background: url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat;
					display: none;
					width: 285px;
					height: 100px;
				}
				.about_more {
					border: 0;
					margin: 10px auto;
					background: #fff;
					display: block;
					width: 110px;
					line-height: 32px;
					float: right;
					text-align: center;
					span:nth-child(1) {
						color: #333;
						font-size: 15px;
					}
					span:nth-child(2) {
						color: #333;
						font-size: 15px;
					}
				}
				.about_more:hover {
					cursor: pointer;
					opacity: 1;
				}
			}
		}
		#system {
			padding: 20px 0 60px;
			background: #fff;
			width: 100%;
			height: auto;
			order: 5;
			.system_item {
				margin: 0 auto;
				display: block;
				width: 1200px;
				flex-wrap: wrap;
				.system_title_box {
					margin: 30px auto;
					width: 100%;
					line-height: 54px;
					text-align: center;
					.system_title {
						margin: 0 20px 0 0;
						color: #333;
						display: inline-block;
						font-size: 40px;
					}
					.system_subtitle {
						color: #999;
						display: inline-block;
						font-size: 24px;
					}
				}
				.system_img {
					padding: 0px;
					background: none;
					display: flex;
					width: 60%;
					float: right;
					flex-wrap: wrap;
					height: 420px;
					img:nth-child(1) {
						margin: 0 20px 0 0;
						object-fit: cover;
						display: block;
						width: calc(40% - 20px);
						height: 100%;
					}
					img:nth-child(2) {
						object-fit: cover;
						display: block;
						width: 60%;
						height: 100%;
					}
					img:nth-child(3) {
						margin: 0;
						flex: 1;
						object-fit: cover;
						display: none;
						height: 100%;
					}
				}
				.system_content {
					border: 4px double #f7db61;
					padding: 15px 10px 5px 20px;
					margin: 0 20px 10px 0;
					overflow: hidden;
					color: #333;
					background: #fff;
					width: calc(40% - 20px);
					font-size: 16px;
					line-height: 30px;
					float: left;
					height: 360px;
				}
				.system_idea1 {
					background: url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat;
					display: none;
					width: 285px;
					height: 100px;
				}
				.system_idea2 {
					background: url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat;
					display: none;
					width: 285px;
					height: 100px;
				}
				.system_idea3 {
					background: url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat;
					display: none;
					width: 285px;
					height: 100px;
				}
				.system_idea4 {
					background: url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat;
					display: none;
					width: 285px;
					height: 100px;
				}
				.system_more {
					border: 0;
					padding: 0 15px;
					margin: 20px auto 0;
					background: #f7db61;
					display: block;
					width: auto;
					line-height: 32px;
					float: left;
					text-align: center;
					span:nth-child(1) {
						color: #333;
						font-size: 15px;
					}
					span:nth-child(2) {
						color: #333;
						font-size: 15px;
					}
				}
				.system_more:hover {
					cursor: pointer;
					opacity: 1;
				}
			}
		}
		.news {
			margin: 20px 0 0;
			background: #fff;
			width: 100%;
			order: 2;
			.news_title_box {
				margin: 30px auto;
				background: none;
				width: 100%;
				line-height: 54px;
				text-align: center;
				.news_title {
					margin: 0 20px 0 0;
					color: #333;
					font-size: 40px;
				}
				.news_subhead {
					margin: 0 0 10px;
					color: #999;
					width: 100%;
					font-size: 20px;
					line-height: 1.5;
					text-align: center;
				}
			}
			.index-pv1 .animation-box:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
				z-index: 1;
			}
			.index-pv1 .animation-box img:hover {
				transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
				-webkit-perspective: 1000px;
				perspective: 1000px;
				transition: 0.3s;
			}
			.list11 {
				padding: 20px;
				margin: 50px auto;
				overflow: hidden;
				background: none;
				display: flex;
				width: 1200px;
				justify-content: space-between;
				.left_box {
					width: 48%;
					.list-item {
						border: 1px dashed #bbbbbb;
						cursor: pointer;
						padding: 0 0 25px;
						margin: 0 0 24px;
						overflow: hidden;
						display: flex;
						width: 100%;
						border-width: 0 0 1px;
						justify-content: space-between;
						.img {
							width: 185px;
							height: 150px;
							img {
								object-fit: cover;
								width: 100%;
								transition: all 0.3s;
								height: 100%;
							}
						}
						.infoBox {
							width: calc(100% - 205px);
							.name {
								overflow: hidden;
								color: #666;
								white-space: nowrap;
								font-weight: 600;
								width: 100%;
								font-size: 16px;
								line-height: 26px;
								text-overflow: ellipsis;
							}
							.time {
								margin: 10px 0;
								color: #6a6a6a;
								font-size: 14px;
							}
							.desc {
								overflow: hidden;
								color: #858585;
								line-height: 24px;
								height: 72px;
							}
						}
					}
					.list-item:hover {
						.img {
							img {
								transform: scale(1.05);
							}
						}
						.infoBox {
							.name {
								color: #e3c026;
							}
						}
					}
				}
				.right_box {
					padding: 0 0 0 30px;
					overflow: hidden;
					width: 48%;
					height: 418px;
					.list-item {
						position: relative;
						.name {
							cursor: pointer;
							padding: 0 50px 0 25px;
							overflow: hidden;
							color: #353535;
							white-space: nowrap;
							font-weight: normal;
							width: 100%;
							font-size: 15px;
							line-height: 40px;
							position: relative;
							text-overflow: ellipsis;
						}
						.name::before {
							color:  #666;
							top: 0;
							font-weight: normal;
							font-size: 22px;
							line-height: 40px;
							position: absolute;
							right: 25px;
							content: "+";
						}
						.list-item2 {
							border: 1px dashed #bbbbbb;
							padding: 0 25px;
							margin: 0;
							overflow: hidden;
							display: block;
							border-width: 0 0 1px;
							opacity: 0;
							transition: all 0.5s;
							height: 0;
							.desc {
								cursor: pointer;
								margin: 10px 0 0;
								overflow: hidden;
								color: #909090;
								font-size: 14px;
								line-height: 25px;
								height: 200px;
							}
						}
					}
					.list-item.list-item-active {
						.name {
							color: #333;
							background: #f7db61;
						}
						.name::before {
							color: #fff;
							content: "-";
						}
						.list-item2 {
							padding: 0 25px 16px;
							margin: 0 0 10px;
							display: block;
							opacity: 1;
							transition: all 0.5s;
							height: 174px;
						}
					}
				}
			}
			.moreBtn {
				border: 0;
				cursor: pointer;
				margin: 20px auto 40px;
				background: #f7db61;
				display: block;
				width: 110px;
				line-height: 32px;
				text-align: center;
				.text {
					color: #000;
					font-size: 15px;
				}
				.icon {
					color: #000;
					font-size: 15px;
				}
			}
		}
	}
</style>
