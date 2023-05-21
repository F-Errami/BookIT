<template>

  <v-app>
  <div>
    <v-app-bar app color="primary">
      <v-toolbar-title class="mr-5">
        <v-btn flat to="/">BookIT</v-btn>
      </v-toolbar-title>

      <v-btn   @click="search()" color=""> Search</v-btn>
    </v-app-bar>

    <br/>
    <br/>
    <br/>
    <v-container class="mt-5">
      <h1 class="display-4 text-center">Bienvenue sur Bookit</h1>
      <p class="text-center">Votre application de gestion de bibliothèque</p>
      <div class="text-center">
        <v-btn color="primary" large @click="afficherListeLivres">Voir la liste des livres</v-btn>
      </div>
    </v-container>
  </div>
  </v-app>
</template>

<script>
export default {
  methods: {
    afficherListeLivres() {
      this.$router.push('/livres');
    },
    search() {

      {
        // Redirection vers la liste des livres après l'ajout
        this.$router.push('/livres/recherche');
      }
    }

  }
};
</script>

<style scoped>
/* Styles spécifiques au composant LandingPage.vue */
</style>
