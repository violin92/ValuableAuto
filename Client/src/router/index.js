import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/about',
    name: 'about',
    component: () => import('../views/About.vue')
  },
  {
    path: '/search/:brand/:model',
    name: 'search',
    component: () => import('../views/Search.vue'),
    props: true
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/Login.vue')
  },
  {
    path: '/signup',
    name: 'signup',
    component: () => import('../views/Signup.vue')
  },
  {
    path: '/user',
    name: 'user',
    component: () => import('../views/User.vue')
  },
  {
    path: '/advertise',
    name: 'advertise',
    component: () => import('../views/Advertise.vue')
  },
  {
    path: '/trades',
    name: 'trades',
    component: () => import('../views/Trades.vue')
  },
  {
    path: '/trade/:id',
    name: 'trade',
    component: () => import('../views/Trade.vue'),
    props: true
  },
  {
    path: '/filldb',
    name: 'filldb',
    component: () => import('../views/FillDB.vue')
  },
  {
    path: '/migrate',
    name: 'migrate',
    component: () => import('../views/Migrate.vue')
  },
  {
    path: '/addReport',
    name: 'addReport',
    component: () => import('../views/AddReport.vue'),
    props: true
  },
  {
    path: '/vehicles/unapproved',
    name: 'unapproved',
    component: () => import('../views/UnapprovedVehicles.vue')
  },
  {
    path: '/reports',
    name: 'reports',
    component: () => import('../views/ReportsBills.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
