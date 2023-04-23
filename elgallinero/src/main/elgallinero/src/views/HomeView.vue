<script setup>
import navbarComponent from '../components/navbarComponent.vue';
import footerComponent from '../components/footerComponent.vue';
</script>
<template>
  <div>
    <navbarComponent />

    <main class="main-container">
      <div class="title-container">
        <h1>Bienvenido al Gallinero</h1>
        <h4 class="subtitle">Barça, humor y mucho análisis. En ese orden</h4>
      </div>
      <img src="../assets/img/">
      <button class="btn btn-danger">Entrar</button>
    </main>

    <footerComponent />
  </div>
</template>

<style lang="scss" scoped>
@import ".././assets/sass/variables";
.main-container {
  background-image: url(.././assets/img/pxfuel.jpg);
  background-size: cover;
  height: calc(90vh - (64px + 60px));
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  object-fit: cover;
  font-family: $font-text;
}

.title-container {
  margin-bottom: 2rem;
  text-align: center;
}

.title-container h1 {
  margin-bottom: 1rem;
  color: $text-copyright;
  font-size: 3.6rem;
}

.subtitle {
  position: relative;
  font-size: 1.5rem;
  color: white;
  background-color: $background;
  padding: 0.2rem 0.5rem;
  border-radius: 5px;
  animation: snake 5s ease-in-out infinite;
}

@keyframes snake {
  0% {
    transform: skewY(0deg);
  }
  25% {
    transform: skewY(5deg);
  }
  50% {
    transform: skewY(0deg);
  }
  75% {
    transform: skewY(-5deg);
  }
  100% {
    transform: skewY(0deg);
  }
}
</style>
