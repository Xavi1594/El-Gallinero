import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/elpodcast',
      name: 'elpodcast',
    component: () => import("../views/PodcastView.vue")

    },
    {
      path: '/editararticulos/:id',
      name: 'editararticulos',
      props: true,
      component: () => import("../views/EditarArticulosView.vue"),
    },
    
    {
      path: '/adminarticles',
      name: 'adminarticles',
      props: true,
      component: () => import("../views/AdminArticlesView.vue"),

    },
    {
      path: '/lasgallinas',
      name: 'lasgallinas',
      component: () => import("../views/LasGallinasView.vue"),

    },
    {
      path: '/articulos',
      name: 'articulos',
      props: true,
      component: () => import("../views/ArticulosView.vue"),

    },
    {
      path: '/articuloindividual/:id',
      name: 'articuloindividual',
      component: () => import('@/views/ArticuloIndividualView.vue'),
      props: true,
    },
    {
      path: '/creararticulos',
      name: 'creararticulos',
      props: true,
      component: () => import("../views/CrearArticulosView.vue"),

    },
    {
      path: '/login',
      name: 'login',
      component: () => import("../views/LoginView.vue"),

    },

  ]
})

export default router
