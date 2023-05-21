import { createRouter, createWebHistory } from 'vue-router';

import ListeLivres from './components/ListeLivres.vue';
import AjoutLivre from './components/AjoutLivre.vue';
import ModifierLivre from './components/ModifierLivre.vue';
import RechercheLivre from './components/RechercheLivre.vue';
import LandingPage from './components/LandingPage.vue';

const routes = [
    {
        path: '/home',
        name: 'LandingPage',
        component: LandingPage
    },
    {
        path: '/',
        name: 'LandingPage',
        component: LandingPage
    },
    {
        path: '/livres',
        name: 'ListeLivres',
        component: ListeLivres
    },
    {
        path: '/livres/ajout',
        name: 'AjoutLivre',
        component: AjoutLivre
    },
    {
        path: '/livres/modifier/:id',
        name: 'ModifierLivre',
        component: ModifierLivre
    },
    {
        path: '/livres/recherche',
        name: 'RechercheLivre',
        component: RechercheLivre
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;
