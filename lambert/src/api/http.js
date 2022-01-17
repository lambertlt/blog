import axios from 'axios'
// 创建axios实例
const service = axios.create({
    // baseURL: baseUrl, // api 的 base_url
    // baseURL: 'http://47.94.160.237:8888/', // api 的 base_url
    baseURL: 'http://localhost:8080/', // api 的 base_url
    // baseURL: 'http://localhost:8888', // api 的 base_url
    // baseURL: 'https://www.baidu.com/', // api 的 base_url
    method: "post",
    timeout: 300000, // 请求超时时间
    headers: {
        "Content-Type": "application/json"
    },
    encode: "charset=utf-8",
    withCredentials: true, // 默认携带cookies
})
// request 拦截器
service.interceptors.request.use(
    config => {
        return config
    },
    error => {
        console.log(error) // for debug
        Promise.reject(error)
    }
)
// response 拦截器
service.interceptors.response.use(
    response => {
        return response.data
    },
    error => {
        console.log('err' + error) // for debug
        return Promise.reject(error)
    }
)
export default service

