<script setup>
import { defineProps } from 'vue';

const props = defineProps({
  item: { type: Object },
  defaultImage: { type: String, default: 'https://www.fcbarcelona.com/photo-resources/2020/04/27/57da04df-c7d0-428f-b95c-79f1d2b56941/5.jpg?width=1200&height=750' }
});


</script>
<template>
    <div class="card">
      <div class="row g-0">
        <div class="col-md-6" v-if="item && item.imageArticle">
          <img :src="item.imageArticle">
        </div>
        <div class="col-md-6" v-else>
          <img src="https://www.fcbarcelona.com/photo-resources/2020/04/27/57da04df-c7d0-428f-b95c-79f1d2b56941/5.jpg?width=1200&height=750">
        </div>
        <div class="col-md-6">
          <div class="card-body">
            <h5 class="card-title">{{ item && item.title }}</h5>
            <pre class="card-text">{{ item && item.content }}</pre>
          </div>
        </div>
      </div>
    </div>
  </template>
<style scoped lang="scss">
@import "../.././src/assets/sass/variables";
@import "../.././src/assets/sass/global.scss";

.strong {
  font-weight: bold;
}

ul li::before {
  content: "- ";
}

ul.strong li::before {
  content: "";
}

h6 {
  font-weight: bold;
  text-decoration: underline;
}

.card-body {
  background-color: #ffffff;
}

h5 {
  color: #cc0033;
}

img {
  width: 100%;
  object-fit: cover;
  aspect-ratio: 1/1;
}

.card {
  --bs-card-border-width: none;
  --bs-card-border-color: var(--bs-border-color-translucent);
  --bs-card-border-radius: none;
  --bs-card-inner-border-radius: calc(none);
  border: none;
  border-radius: none;
}

.card:nth-child(even) .row {
  flex-direction: row-reverse;
}

.card-body {
  overflow: auto;
  height: 44vw;
  scrollbar-color: rgba(0, 0, 0, 0.5) rgba(0, 0, 0, 0);
  scrollbar-width: thin;
  margin-right: 15px;
  margin-top: 15px;
  padding: 3em 4em 4em 4em;
}

.card-body::-webkit-scrollbar {
  -webkit-appearance: none;
}

.card-body::-webkit-scrollbar:vertical {
  width: 10px;
}

.card-body::-webkit-scrollbar-button:increment,
.card-body::-webkit-scrollbar-button {
  display: none;
}

.card-body::-webkit-scrollbar:horizontal {
  height: 10px;
}

.card-body::-webkit-scrollbar-thumb {
  // background-color: $background-green;
  border-radius: 20px;
  border: 2px solid #f1f2f3;
}

.contenedor::-webkit-scrollbar-track {
  border-radius: 10px;
}

pre {
  white-space:pre-line;
  // font-family: $font-text;
  font-size: 1rem;
}

@media (max-width: 768px) {
  .card-body {
    height: 100vw;
    padding: 1rem;
  }
}
</style>
