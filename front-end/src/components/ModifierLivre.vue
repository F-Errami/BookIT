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
  <div>

    <h2>Modifier Livre</h2>
    <v-form @submit.prevent="modifierLivre">
      <v-container>
        <v-row>
          <v-col cols="12">
            <v-text-field
                v-model="livre.titre"
                label="Titre"
                outlined
            ></v-text-field>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="12">
            <v-text-field
                v-model="livre.auteur"
                label="Auteur"
                outlined
            ></v-text-field>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="12">
            <v-textarea
                v-model="livre.resume"
                label="Résumé"
                outlined
            ></v-textarea>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="12">
            <v-date-picker
                v-model="datePublication"
                label="Date de publication"

            ></v-date-picker>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="12">
            <v-btn type="submit" color="primary">Modifier</v-btn>
          </v-col>
        </v-row>
      </v-container>
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
      livre: {
        titre: '',
        auteur: '',
        resume: '',
         datePublication:''
      },
      datePublication: ''

    };
  },
  mounted() {
    const id = this.$route.params.id;
    this.fetchLivre(id);
  },
  methods: {
    fetchLivre(id) {
      this.$http.get(`/livres/${id}`)
          .then(response => {
            this.livre = response.data;

          })
          .catch(error => {
            console.error(error);
          });
    },
    modifierLivre() {
      const id = this.$route.params.id;
      if(this.datePublication !='') {
        this.livre.datePublication = this.datePublication;
      }
      this.$http.put(`/livres/${id}`, this.livre)
          .then(() => {
            this.$router.push({ name: 'ListeLivres' });
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

<style scoped>
/* Styles spécifiques au composant ModifierLivre.vue */
</style>
