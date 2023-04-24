<script setup>
</script>

<template>
  <footer class="footer w-100 ">
    <div class="footer__container-log">
      <img
        src="../assets/img/gallinero_logo-removebg-preview.png"
        alt="logo gallinero"
      />
    </div>
    <div class="footer__container-title">
      <p class="footer__container-title__slogan">
        “Caldo de gallina,<br />
        es famosa medicina"<br />
        
      </p>
      <p class="footer__container-title__copyright">&copy; El Gallinero</p>
    </div>
    <div class="footer__container-navigation">
      <ul>
        <li>
          <RouterLink class="nav-link" to="/">Inicio</RouterLink>
        </li>

        <li>
          <RouterLink to="/elpodcast" class="nav-link"
            >El Podcast</RouterLink
          >
        </li>
        <li>
          <RouterLink to="#" class="nav-link"
            >Mejores hilos</RouterLink
          >
        </li>
        <li>
          <RouterLink class="nav-link" to="#"
            >Las gallinas</RouterLink
          >
        </li>
        <li>
          <RouterLink class="nav-link" to="#"
            >Humor gallino</RouterLink
          >
        </li>
        <li>
          <RouterLink class="nav-link" to="">Historia culé</RouterLink>
        </li>
        <li>
          <RouterLink class="nav-link" to="/login">Login</RouterLink>
        </li>
      </ul>
    </div>
    <div class="footer__container-social-media">
      <a
        href="https://twitter.com/GallineroBlau?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor"
        target="_blank"
        ><img
          class="image-icon icons"
          src="../assets/img/twitter (1).svg"
          alt="twitter-icon"
      /></a>

      <a
        href="https://www.twitch.tv/elgallinero_oficial?lang=es"
        target="_blank"
        ><img
          class="image-icon icons"
          src="../assets/img/twitch.svg"
          alt="twitch-icon"
      /></a>
    </div>
  </footer>
</template>

<style lang="scss" scoped>
@import "../assets/sass/variables";

.footer {
  background-color: $background;
  display: flex;
  flex-wrap: wrap;
  gap: 3rem;
  justify-content: space-around;
  align-items: end;
  color: $background-component;
  padding: 2rem;
 margin-bottom: 0;
 

  &__container-log {
    img {
      width: 237px;
    }
  }

  &__container-title {
    font-family: $font-text;
    display: flex;
    flex-direction: column;
    justify-content: end;
    align-items: start;

    &__slogan {
      font-size: 1.25rem;
      color: $subtitle;
    }

    &__copyright {
      font-size: 2vh;
      color: $text-copyright;
      margin-bottom: 0.2rem;
    }
  }

  &__container-navigation {

    ul {
      padding: 0;
      margin-bottom: 0.2rem;
      color: $text-copyright ;

    }
    a {
      
      transition: all 0.4s;
    }
    a.router-link-exact-active,
    a:hover {
      color: $text-copyright ;
      letter-spacing: 1px;
    }
  }

  &__container-social-media {
    align-self: center;
    display: flex;
    flex-wrap: nowrap;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    cursor: pointer;
  }
  .icons {
    margin: 1vh;
    opacity: 100%;
  }
  .icons a:hover {
    opacity: 50%;
  }
}

</style>
