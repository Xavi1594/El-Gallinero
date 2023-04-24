<template>
  <div>
    <individualCartArticle :item="item" />
  </div>
</template>

<script setup>
import { defineProps } from 'vue';
import individualCartArticle from '../components/individualCartArticle.vue';

const props = defineProps({
  item: { type: Object },
});

const components = {
  individualCartArticle,
};
</script>
