<script setup>
    import { ref } from 'vue'
    const count = ref(10)
</script>


<template>
    <button @click="count++">count: {{ count }}</button>
</template>