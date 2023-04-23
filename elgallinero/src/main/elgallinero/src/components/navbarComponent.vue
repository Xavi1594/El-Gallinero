<script setup>
import { RouterLink } from "vue-router";
</script>

<template>
  <nav class="navbar navbar-expand-lg">
    <div class="container">
      <a href="/" class="navbar-brand"><img src="../assets/img/gallinero_logo-removebg-preview.png" alt="logo gallina" class="logo" style="width: 200px; height: 200px;"></a>
      <i class="bi bi-wechat"></i>
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <RouterLink class="nav-link" to="/">Inicio</RouterLink>
          </li>

          <li class="nav-item">
            <RouterLink to="/elpodcast" class="nav-link"
              >El Podcast</RouterLink
            >
          </li>
          <li class="nav-item">
            <RouterLink to="/creararticulos" class="nav-link"
              >Crear artículo</RouterLink
            >
          </li>
          <li class="nav-item">
            <RouterLink class="nav-link" to="/lasgallinas"
              >Las gallinas</RouterLink
            >
          </li>
          <li class="nav-item">
            <RouterLink class="nav-link" to="/articulos"
              >Artículos</RouterLink
            >
          </li>
          <li class="nav-item">
            <RouterLink class="nav-link" to="/editararticulos">Editar artículos</RouterLink>
          </li>
          <li class="nav-item">
            <RouterLink class="nav-link" to="/login"
              >Login</RouterLink
            >
          </li>
        
        </ul>
      </div>
    </div>
  </nav>
</template>
<style lang="scss" scoped>
@import url(.././assets/sass/_variables.scss);
nav {
  height: 80px;
  .container {
    img.logo {
      min-width: 100px;
    }
  }
}
.navbar {
  background-color: #181733;
  a {
    color: #fff;
    white-space: nowrap;
    transition: all 0.4s;
  }
  a.router-link-exact-active,
  a:hover {
    letter-spacing: 1px;
  }
}
</style>
