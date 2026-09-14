const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot14cvvg52/",
            name: "springboot14cvvg52",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot14cvvg52/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "爱心小屋捐赠系统的设计与实现"
        } 
    }
}
export default base
