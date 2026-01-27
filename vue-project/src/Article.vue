<script setup>
import { ref, onMounted } from 'vue';
import { articleGetAllService, articleSearchService } from './api/article.js';

// 定义响应式数据，用于存储文章列表
const articlelist = ref([]);
const searchConditions = ref({
    category: '',  // 分类搜索条件
    state: ''      // 状态搜索条件
});

// 组件挂载完成后执行，获取所有文章数据
onMounted(async () => {
    try {
        // 使用 async/await 方式调用 API
        const data = await articleGetAllService();
        articlelist.value = data;
        console.log(data);
    } catch (error) {
        console.error("加载文章列表失败:", error);
    }
});

// 搜索功能函数
const search = async () => {
    try {
        // 调用搜索服务
        const data = await articleSearchService(searchConditions.value);
        articlelist.value = data;
        console.log(data);
    } catch (error) {
        console.error("搜索失败:", error);
    }
};
</script>

<template>
    <div>
        <!-- 搜索表单区域 -->
        文章分类: <input type="text" v-model="searchConditions.category">
        发布状态: <input type="text" v-model="searchConditions.state">
        <button @click="search">搜索</button>

        <br />
        <br />
        
        <!-- 文章列表表格 -->
        <table border="1 solid" cellpadding="0" cellspacing="0">
            <tr>
                <th>文章标题</th>
                <th>分类</th>
                <th>发表时间</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            <tr v-for="article in articlelist" :key="article.id || $index">
                <td>{{ article.title }}</td>
                <td>{{ article.category }}</td>
                <td>{{ article.time }}</td>
                <td>{{ article.state }}</td>
                <td>
                    <button>编辑</button>
                    <button>删除</button>
                </td>
            </tr>
        </table>
    </div>
</template>