<template>

  <v-app>
  <div>

  <v-app-bar  app color="primary">
    <v-toolbar-title class="mr-5">
      <v-btn flat to="/">BookIT</v-btn>
    </v-toolbar-title>



      <v-btn   @click="search()" color=""> Search</v-btn>


  </v-app-bar>/

  </div>
    <br/>
    <br/>
    <br/>

  <div>

    <h2>Ajouter un livre</h2>
    <!-- Formulaire pour l'ajout d'un livre -->
    <v-form @submit.prevent="ajouterLivre">
      <v-text-field v-model="nouveauLivre.titre" label="Titre" required></v-text-field>
      <v-text-field v-model="nouveauLivre.auteur" label="Auteur" required></v-text-field>
      <v-textarea v-model="nouveauLivre.resume" label="Résumé" required></v-textarea>
      <v-date-picker v-model="nouveauLivre.datePublication" required></v-date-picker>
      <v-btn type="submit" color="primary">Ajouter</v-btn>

    </v-form>
  </div>
  </v-app>
</template>

<script>
import VDatePicker from 'vue3-datepicker'
export default {
  components: {
    VDatePicker
  },

  data() {

    return {
      nouveauLivre: {
        titre: '',
        auteur: '',
        resume: '',
        datePublication: ''
      }
    };
  },
  methods: {
    ajouterLivre() {
      if (this.validateForm()) {
        this.$http
            .post('/livres', this.nouveauLivre)
            .then(() => {
              // Redirection vers la liste des livres après l'ajout
              this.$router.push('/livres');
            })
            .catch(error => {
              console.error(error);
            });
      }
    },
    validateForm() {
      // Check if any field is empty
      if (
          this.nouveauLivre.titre =='' ||
          this.nouveauLivre.auteur=='' ||
          this.nouveauLivre.resume=='' ||
          this.nouveauLivre.datePublication==''
      ) {

        return false;
      }
      return true;
    },
   search() {

     {
       // Redirection vers la liste des livres après l'ajout
       this.$router.push('/livres/recherche');
     }
   }


}};
</script>

<style scoped>

</style>
