import request from './http' // 使用实例

//get方法
export function contentDetail(params) {
    return request({
        url: '/superwbs-server/tech/contentDetail',
        method: 'get',
        params
    })
}

//get方法
export function GetReadme(params) {
    return request({
        url: params,
        method: 'get'
    })
}


//post方法
export function postGetUserAll(params) {
    return request({
        url: '/superwbs-server/tech/contentDetail',
        method: 'post',
        data: params
    })
}


