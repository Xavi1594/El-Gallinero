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
      path: '/historiacule',
      name: 'historiacule',
      component: () => import("../views/HistoriaCuleView.vue"),

    },
    {
      path: '/mejoreshilos',
      name: 'mejoreshilos',
      component: () => import("../views/MejoresHilosView.vue"),

    },
    {
      path: '/lasgallinas',
      name: 'lasgallinas',
      component: () => import("../views/LasGallinasView.vue"),

    },
    {
      path: '/humorgallino',
      name: 'humorgallino',
      component: () => import("../views/HumorGallinoView.vue"),

    },
    {
      path: '/login',
      name: 'login',
      component: () => import("../views/LoginView.vue"),

    },
  ]
})

export default router
