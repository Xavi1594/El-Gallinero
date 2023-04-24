
<script setup>
import cardArticleComponent from './cardArticleComponent.vue';
import { defineProps } from 'vue';

const props = defineProps({
  item: { type: Object },
});
</script>

<template>
    <div>
      <h2>{{ item.title }}</h2>
      <p>{{ item.content }}</p>
    </div>
  </template>