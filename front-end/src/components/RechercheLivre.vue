<template>

  <v-app>
    <v-app-bar app color="primary">
      <v-toolbar-title class="mr-5">
        <v-btn flat to="/">BookIT</v-btn>
      </v-toolbar-title>

      <v-btn   @click="search()" color=""> Search</v-btn>
    </v-app-bar>


  <div>
    <br/>
    <br/>
    <br/>
    <v-spacer></v-spacer>
    <h2>Rechercher des livres</h2>

    <div class="form-group">

      <v-form @submit.prevent="searchLivres">
        <v-text-field v-model="searchCriteria.title" label="Titre" required></v-text-field>
        <v-text-field v-model="searchCriteria.author" label="Auteur" required></v-text-field>
        <v-btn type="submit" color="primary">Rechercher</v-btn>
      </v-form>
    </div>


    <!-- Display the search results -->
    <div v-if="searchResults.length > 0">
      <h3>Résultats de recherche</h3>
      <v-table>
        <thead>
        <tr>
          <th class="text-left">
            Titre
          </th>
          <th class="text-left">
            Auteur
          </th>

          <th class="text-left">
            Résumé
          </th>
          <th class="text-left">
            Date de Publication
          </th>



        </tr>
        </thead>
        <tbody>
        <tr
            v-for="livre in searchResults"
            :key="livre.id"
        >
          <td>{{ livre.titre }}</td>
          <td>{{ livre.auteur }}</td>
          <td>{{ livre.resume }}</td>
          <td>{{ livre.datePublication }}</td>
        </tr>
        </tbody>
      </v-table>
    </div>
  </div>
  </v-app>
</template>

<script>
export default {
  data() {
    return {
      searchCriteria: {
        title: '',
        author: ''
      },
      searchResults: []
    };
  },
  methods: {
    searchLivres() {
      const { title, author } = this.searchCriteria;
      const queryParams = {};

      if (title) {
        queryParams.titre = title;
      }
      if (author) {
        queryParams.auteur = author;
      }

      this.$http.get('/livres/recherche', { params: queryParams })
          .then(response => {
            this.searchResults = response.data;
          })
          .catch(error => {
            console.error(error);
          });
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

<style>
/* Styles spécifiques au composant RechercheLivre.vue */
</style>
