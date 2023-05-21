<template>

  <v-app>

      <v-app-bar app color="primary">
        <v-toolbar-title class="mr-5">
          <v-btn flat to="/">BookIT</v-btn>
        </v-toolbar-title>

        <v-btn   @click="search()" color=""> Search</v-btn>
      </v-app-bar>

    <br/>
    <br/>
    <br/>
    <h1> Liste des livres</h1>
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
      <th class="text-left">

      </th>
    </tr>
    </thead>
    <tbody>
    <tr
        v-for="livre in livres"
        :key="livre.id"
    >
      <td>{{ livre.titre }}</td>
      <td>{{ livre.auteur }}</td>
      <td>{{ livre.resume }}</td>
      <td>{{ livre.datePublication }}</td>
      <td>
        <v-btn @click="modifierLivre(livre)" color="primary">Modifier</v-btn>
        <v-btn @click="supprimerLivre(livre.id)" color="error">Supprimer</v-btn>

      </td>
    </tr>
    </tbody>
  </v-table>
  <v-btn @click="ajouterLivre" color="primary">Ajouter</v-btn>
    </v-app>
</template>



<script>




export default {

  data() {
    return {
      livres: [],

    };
  },
  mounted() {
    this.fetchLivres();
  },
  methods: {
    fetchLivres() {
      this.$http
          .get('/livres')
          .then(response => {
            this.livres = response.data;
          })
          .catch(error => {
            console.error(error);
          });
    },
    modifierLivre(livre) {
      this.$router.push({ name: 'ModifierLivre', params: { id: livre.id } });
    },
    supprimerLivre(id) {
      this.$http
          .delete(`/livres/${id}`)
          .then(() => {
            // Actualiser la liste des livres après la suppression
            this.fetchLivres();
          })
          .catch(error => {
            console.error(error);
          });
    },
    ajouterLivre() {
      this.$router.push({ name: 'AjoutLivre' });
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
/* Styles spécifiques au composant ListeLivres.vue */
</style>
