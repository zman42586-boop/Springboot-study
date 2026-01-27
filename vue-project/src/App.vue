<!-- <script>
  export default {
    data() {
      return {
        msg: '上海!'
      }
    }
  }
</script> -->
<script setup>
  // import { ref } from 'vue'
  // // 状态
  // const msg = ref('xian!')
  // // import Apivue from './api.vue'
  import ArticleVue from './Article.vue'
</script>

<template>
  <!-- html -->
   <!-- <h1>{{ msg }}</h1> -->
   <br>
   <Apivue />
   <ArticleVue></ArticleVue>
</template>

<style scoped>
/* 样式 */
h1 {
  color: red;
}
</style>
