import VueRouter from 'vue-router'
//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import juanzengzheList from '../pages/juanzengzhe/list'
import juanzengzheDetail from '../pages/juanzengzhe/detail'
import juanzengzheAdd from '../pages/juanzengzhe/add'
import shouzhuzheList from '../pages/shouzhuzhe/list'
import shouzhuzheDetail from '../pages/shouzhuzhe/detail'
import shouzhuzheAdd from '../pages/shouzhuzhe/add'
import zhiyuanzheList from '../pages/zhiyuanzhe/list'
import zhiyuanzheDetail from '../pages/zhiyuanzhe/detail'
import zhiyuanzheAdd from '../pages/zhiyuanzhe/add'
import kefurenyuanList from '../pages/kefurenyuan/list'
import kefurenyuanDetail from '../pages/kefurenyuan/detail'
import kefurenyuanAdd from '../pages/kefurenyuan/add'
import juanzengwupinshenqingList from '../pages/juanzengwupinshenqing/list'
import juanzengwupinshenqingDetail from '../pages/juanzengwupinshenqing/detail'
import juanzengwupinshenqingAdd from '../pages/juanzengwupinshenqing/add'
import juanzengjiluList from '../pages/juanzengjilu/list'
import juanzengjiluDetail from '../pages/juanzengjilu/detail'
import juanzengjiluAdd from '../pages/juanzengjilu/add'
import jieshoujuanzengList from '../pages/jieshoujuanzeng/list'
import jieshoujuanzengDetail from '../pages/jieshoujuanzeng/detail'
import jieshoujuanzengAdd from '../pages/jieshoujuanzeng/add'
import fankuijuanzengList from '../pages/fankuijuanzeng/list'
import fankuijuanzengDetail from '../pages/fankuijuanzeng/detail'
import fankuijuanzengAdd from '../pages/fankuijuanzeng/add'
import gongyihuodongList from '../pages/gongyihuodong/list'
import gongyihuodongDetail from '../pages/gongyihuodong/detail'
import gongyihuodongAdd from '../pages/gongyihuodong/add'
import wentifankuiList from '../pages/wentifankui/list'
import wentifankuiDetail from '../pages/wentifankui/detail'
import wentifankuiAdd from '../pages/wentifankui/add'
import chatmessageList from '../pages/chatmessage/list'
import chatmessageDetail from '../pages/chatmessage/detail'
import chatmessageAdd from '../pages/chatmessage/add'
import friendList from '../pages/friend/list'
import friendDetail from '../pages/friend/detail'
import friendAdd from '../pages/friend/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import aboutusList from '../pages/aboutus/list'
import aboutusDetail from '../pages/aboutus/detail'
import aboutusAdd from '../pages/aboutus/add'
import systemintroList from '../pages/systemintro/list'
import systemintroDetail from '../pages/systemintro/detail'
import systemintroAdd from '../pages/systemintro/add'
import discussgongyihuodongList from '../pages/discussgongyihuodong/list'
import discussgongyihuodongDetail from '../pages/discussgongyihuodong/detail'
import discussgongyihuodongAdd from '../pages/discussgongyihuodong/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
    return originalPush.call(this, location).catch(err => err)
}
//路由是指通过特定的 URL 路径将请求映射到相应的处理函数。
//配置路由
export default new VueRouter({
    routes: [
        {
            path: '/',
            redirect: '/index/home'
        },
        {
            path: '/index',
            component: Index,
            children: [
                {
                    path: 'home',
                    component: Home
                },
                {
                    path: 'center',
                    component: Center,
                },
                {
                    path: 'pay',
                    component: payList,
                },
                {
                    path: 'storeup',
                    component: Storeup
                },
                {
                    path: 'news',
                    component: News
                },
                {
                    path: 'newsDetail',
                    component: NewsDetail
                },
                {
                    path: 'juanzengzhe',
                    component: juanzengzheList
                },
                {
                    path: 'juanzengzheDetail',
                    component: juanzengzheDetail
                },
                {
                    path: 'juanzengzheAdd',
                    component: juanzengzheAdd
                },
                {
                    path: 'shouzhuzhe',
                    component: shouzhuzheList
                },
                {
                    path: 'shouzhuzheDetail',
                    component: shouzhuzheDetail
                },
                {
                    path: 'shouzhuzheAdd',
                    component: shouzhuzheAdd
                },
                {
                    path: 'zhiyuanzhe',
                    component: zhiyuanzheList
                },
                {
                    path: 'zhiyuanzheDetail',
                    component: zhiyuanzheDetail
                },
                {
                    path: 'zhiyuanzheAdd',
                    component: zhiyuanzheAdd
                },
                {
                    path: 'kefurenyuan',
                    component: kefurenyuanList
                },
                {
                    path: 'kefurenyuanDetail',
                    component: kefurenyuanDetail
                },
                {
                    path: 'kefurenyuanAdd',
                    component: kefurenyuanAdd
                },
                {
                    path: 'juanzengwupinshenqing',
                    component: juanzengwupinshenqingList
                },
                {
                    path: 'juanzengwupinshenqingDetail',
                    component: juanzengwupinshenqingDetail
                },
                {
                    path: 'juanzengwupinshenqingAdd',
                    component: juanzengwupinshenqingAdd
                },
                {
                    path: 'juanzengjilu',
                    component: juanzengjiluList
                },
                {
                    path: 'juanzengjiluDetail',
                    component: juanzengjiluDetail
                },
                {
                    path: 'juanzengjiluAdd',
                    component: juanzengjiluAdd
                },
                {
                    path: 'jieshoujuanzeng',
                    component: jieshoujuanzengList
                },
                {
                    path: 'jieshoujuanzengDetail',
                    component: jieshoujuanzengDetail
                },
                {
                    path: 'jieshoujuanzengAdd',
                    component: jieshoujuanzengAdd
                },
                {
                    path: 'fankuijuanzeng',
                    component: fankuijuanzengList
                },
                {
                    path: 'fankuijuanzengDetail',
                    component: fankuijuanzengDetail
                },
                {
                    path: 'fankuijuanzengAdd',
                    component: fankuijuanzengAdd
                },
                {
                    path: 'gongyihuodong',
                    component: gongyihuodongList
                },
                {
                    path: 'gongyihuodongDetail',
                    component: gongyihuodongDetail
                },
                {
                    path: 'gongyihuodongAdd',
                    component: gongyihuodongAdd
                },
                {
                    path: 'wentifankui',
                    component: wentifankuiList
                },
                {
                    path: 'wentifankuiDetail',
                    component: wentifankuiDetail
                },
                {
                    path: 'wentifankuiAdd',
                    component: wentifankuiAdd
                },
                {
                    path: 'chatmessage',
                    component: chatmessageList
                },
                {
                    path: 'chatmessageDetail',
                    component: chatmessageDetail
                },
                {
                    path: 'chatmessageAdd',
                    component: chatmessageAdd
                },
                {
                    path: 'friend',
                    component: friendList
                },
                {
                    path: 'friendDetail',
                    component: friendDetail
                },
                {
                    path: 'friendAdd',
                    component: friendAdd
                },
                {
                    path: 'newstype',
                    component: newstypeList
                },
                {
                    path: 'newstypeDetail',
                    component: newstypeDetail
                },
                {
                    path: 'newstypeAdd',
                    component: newstypeAdd
                },
                {
                    path: 'aboutus',
                    component: aboutusList
                },
                {
                    path: 'aboutusDetail',
                    component: aboutusDetail
                },
                {
                    path: 'aboutusAdd',
                    component: aboutusAdd
                },
                {
                    path: 'systemintro',
                    component: systemintroList
                },
                {
                    path: 'systemintroDetail',
                    component: systemintroDetail
                },
                {
                    path: 'systemintroAdd',
                    component: systemintroAdd
                },
                {
                    path: 'discussgongyihuodong',
                    component: discussgongyihuodongList
                },
                {
                    path: 'discussgongyihuodongDetail',
                    component: discussgongyihuodongDetail
                },
                {
                    path: 'discussgongyihuodongAdd',
                    component: discussgongyihuodongAdd
                },
            ]
        },
        {
            path: '/login',
            component: Login
        },
        {
            path: '/register',
            component: Register
        },
    ]
})
