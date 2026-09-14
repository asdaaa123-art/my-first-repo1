import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
	import news from '@/views/modules/news/list'
	import aboutus from '@/views/modules/aboutus/list'
	import juanzengwupinshenqing from '@/views/modules/juanzengwupinshenqing/list'
	import juanzengjilu from '@/views/modules/juanzengjilu/list'
	import jieshoujuanzeng from '@/views/modules/jieshoujuanzeng/list'
	import gongyihuodong from '@/views/modules/gongyihuodong/list'
	import shouzhuzhe from '@/views/modules/shouzhuzhe/list'
	import systemintro from '@/views/modules/systemintro/list'
	import chat from '@/views/modules/chat/list'
	import discussgongyihuodong from '@/views/modules/discussgongyihuodong/list'
	import juanzengzhe from '@/views/modules/juanzengzhe/list'
	import fankuijuanzeng from '@/views/modules/fankuijuanzeng/list'
	import config from '@/views/modules/config/list'
	import wentifankui from '@/views/modules/wentifankui/list'
	import zhiyuanzhe from '@/views/modules/zhiyuanzhe/list'
	import kefurenyuan from '@/views/modules/kefurenyuan/list'
	import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
	path: '/',
	name: '系统首页',
	component: Index,
	children: [{
		// 这里不设置值，是把main作为默认页面
		path: '/',
		name: '系统首页',
		component: Home,
		meta: {icon:'', title:'center', affix: true}
	}, {
		path: '/updatePassword',
		name: '修改密码',
		component: UpdatePassword,
		meta: {icon:'', title:'updatePassword'}
	}, {
		path: '/pay',
		name: '支付',
		component: pay,
		meta: {icon:'', title:'pay'}
	}, {
		path: '/center',
		name: '个人信息',
		component: center,
		meta: {icon:'', title:'center'}
	}
	,{
		path: '/news',
		name: '公告',
		component: news
	}
	,{
		path: '/aboutus',
		name: '关于我们',
		component: aboutus
	}
	,{
		path: '/juanzengwupinshenqing',
		name: '捐赠物品申请',
		component: juanzengwupinshenqing
	}
	,{
		path: '/juanzengjilu',
		name: '捐赠记录',
		component: juanzengjilu
	}
	,{
		path: '/jieshoujuanzeng',
		name: '接受捐赠',
		component: jieshoujuanzeng
	}
	,{
		path: '/gongyihuodong',
		name: '公益活动',
		component: gongyihuodong
	}
	,{
		path: '/shouzhuzhe',
		name: '受助者',
		component: shouzhuzhe
	}
	,{
		path: '/systemintro',
		name: '系统简介',
		component: systemintro
	}
	,{
		path: '/chat',
		name: '投诉建议',
		component: chat
	}
	,{
		path: '/discussgongyihuodong',
		name: '公益活动评论',
		component: discussgongyihuodong
	}
	,{
		path: '/juanzengzhe',
		name: '捐赠者',
		component: juanzengzhe
	}
	,{
		path: '/fankuijuanzeng',
		name: '反馈捐赠',
		component: fankuijuanzeng
	}
	,{
		path: '/config',
		name: '轮播图管理',
		component: config
	}
	,{
		path: '/wentifankui',
		name: '问题反馈',
		component: wentifankui
	}
	,{
		path: '/zhiyuanzhe',
		name: '志愿者',
		component: zhiyuanzhe
	}
	,{
		path: '/kefurenyuan',
		name: '客服人员',
		component: kefurenyuan
	}
	,{
		path: '/newstype',
		name: '公告分类',
		component: newstype
	}
	]
	},
	{
		path: '/login',
		name: 'login',
		component: Login,
		meta: {icon:'', title:'login'}
	},
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {icon:'', title:'register'}
	},
	{
		path: '*',
		component: NotFound
	}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
	mode: 'hash',
	/*hash模式改为history*/
	routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
export default router;
