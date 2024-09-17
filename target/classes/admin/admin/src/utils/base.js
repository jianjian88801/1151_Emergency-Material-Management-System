const base = {
    get() {
        return {
            url : "http://localhost:8080/changguiyingji/",
            name: "changguiyingji",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/changguiyingji/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "常规应急物资管理系统"
        } 
    }
}
export default base
