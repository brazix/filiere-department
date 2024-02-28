<template>
  <div>
    <h2>Filières</h2>
    <button @click="showFiliereForm = true">Add Filiere</button>
    <form v-if="showFiliereForm" @submit.prevent="createFiliere">
      <input type="text" v-model="filiereName" placeholder="Filiere Name" required>
      <select v-model="selectedDepartment">
        <option v-for="department in departments" :key="department.id" :value="department.id">{{ department.name }}</option>
      </select>
      <button type="submit">Save</button>
    </form>
    <ul>
      <li v-for="filiere in filieres" :key="filiere.id">
        {{ filiere.name }}
        <button @click="deleteFiliere(filiere.id)">Delete</button>
      </li>
    </ul>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';

const baseURL = 'http://127.0.0.1:9090';

const filieres = ref([]);
const showFiliereForm = ref(false);
const filiereName = ref('');
const selectedDepartment = ref('');
const departments = ref([]);

const fetchFilieres = () => {
  axios.get(`${baseURL}/filieres`)
    .then(response => {
      filieres.value = response.data;
    })
    .catch(error => {
      console.error('Error fetching filieres:', error);
    });
};

const fetchDepartments = () => {
  axios.get(`${baseURL}/departments`)
    .then(response => {
      departments.value = response.data;
    })
    .catch(error => {
      console.error('Error fetching departments:', error);
    });
};

const createFiliere = () => {
  axios.post(`${baseURL}/filieres`, { 
    name: filiereName.value, 
    department: { 
      id: selectedDepartment.value 
    } 
  })
  .then(() => {
    fetchFilieres();
    showFiliereForm.value = false;
    filiereName.value = '';
    selectedDepartment.value = '';
  })
  .catch(error => {
    console.error('Error creating filiere:', error);
  });
};

const deleteFiliere = (id) => {
  axios.delete(`${baseURL}/filieres/${id}`)
    .then(() => {
      fetchFilieres();
    })
    .catch(error => {
      console.error('Error deleting filiere:', error);
    });
};

onMounted(() => {
  fetchFilieres();
  fetchDepartments();
});
</script>
