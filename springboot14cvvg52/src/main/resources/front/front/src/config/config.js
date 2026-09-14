export default {
	baseUrl: 'http://localhost:8080/springboot14cvvg52/',
	name: '/springboot14cvvg52',
	indexNav: [
		{
			name: '客服人员',
			url: '/index/kefurenyuan',
		},
		{
			name: '反馈捐赠',
			url: '/index/fankuijuanzeng',
		},
		{
			name: '公益活动',
			url: '/index/gongyihuodong',
		},
		{
			name: '公告',
			url: '/index/news'
		},
	],
	cateList: [
		{
			name: '公告',
			refTable: 'newstype',
			refColumn: 'typename',
		},
	]
}
