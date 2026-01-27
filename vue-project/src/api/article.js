// src/api/article.js
import axios from 'axios';

// 获取所有文章的服务
export function articleGetAllService(){
    // 返回 Promise 对象，让调用方可以等待结果
    return axios.get("http://localhost:8080/article/getAll")
        .then((res) => {
            return res.data;  // 返回数据
        })
        .catch((error) => {
            console.error("获取文章列表失败:", error);
            throw error;  // 抛出错误，让调用方知道请求失败
        });
}

// 搜索文章的服务
export function articleSearchService(conditions){
    // 返回 Promise 对象
    return axios.get("http://localhost:8080/article/search", {
        params: conditions
    })
    .then((res) => {
        return res.data;  // 返回搜索结果
    })
    .catch((error) => {
        console.error("搜索文章失败:", error);
        throw error;  // 抛出错误
    });
}