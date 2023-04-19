<script setup>
import navbarComponent from '../components/navbarComponent.vue';
import footerComponent from '../components/footerComponent.vue';
</script>

<template>

    
  <main>
  <navbarComponent />
  

   <h1>Bienvenido al Gallinero</h1>
   <h4 class="subtitle">Barça, humor y mucho análisis.
En ese orden</h4>
</main>
<footerComponent />
</template>

<style lang="scss" scoped>
@import ".././assets/sass/variables";
@import ".././assets/sass/styles.scss";

main {
  background-image: url(.././assets/img/Screen.png);
  h1{
    color: $text-copyright;
    
  }
  .subtitle {
    color: $subtitle;
    font-size: 1.2rem;


}
}


</style>
