<script setup>
import navbarComponent from '../components/navbarComponent.vue';
</script>

<template>
  <main>
  <navbarComponent />

   <h1>Bienvenido al Gallinero</h1>
  </main>
</template>
<style lang="scss" scoped>
@import ".././assets/sass/variables";
@import ".././assets/sass/styles.scss";

main {
  background-image: url(.././assets/img/Screen.png);
  h1{
    color: $text-copyright;
    font-family: $font-text;
  }
}


</style>