
<script setup>
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