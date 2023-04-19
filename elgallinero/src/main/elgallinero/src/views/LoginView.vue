<script setup>
import navbarComponent from '../components/navbarComponent.vue';
import loginComponent from '../components/loginComponent.vue';
import footerComponent from '../components/footerComponent.vue';
</script>
<template>
<navbarComponent />
<div class="view-container">
   <loginComponent />

    </div>


<footerComponent />

</template>

<style lang="scss" scoped>
.view-container{

    background-image: url("../assets/img/pxfuel.jpg");
    height: 100vh;
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    background-repeat: no-repeat;
    background-size: cover;
}

    
</style>