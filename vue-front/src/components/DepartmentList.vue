<template>
    <div>
      <h2>Departments</h2>
      <button @click="showDepartmentForm = true">Add Department</button>
      <form v-if="showDepartmentForm" @submit.prevent="createDepartment">
        <input type="text" v-model="departmentName" placeholder="Department Name" required>
        <button type="submit">Save</button>
      </form>
      <ul>
        <li v-for="department in departments" :key="department.id">
          {{ department.name }}
          <button @click="deleteDepartment(department.id)">Delete</button>
        </li>
      </ul>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  import axios from 'axios';
  
  const baseURL = 'http://127.0.0.1:9090';
  
  const departments = ref([]);
  const showDepartmentForm = ref(false);
  const departmentName = ref('');
  
  const fetchDepartments = () => {
    axios.get(`${baseURL}/departments`)
      .then(response => {
        departments.value = response.data;
      })
      .catch(error => {
        console.error('Error fetching departments:', error);
      });
  };
  
  const createDepartment = () => {
    axios.post(`${baseURL}/departments`, { name: departmentName.value })
      .then(() => {
        fetchDepartments();
        showDepartmentForm.value = false;
        departmentName.value = '';
      })
      .catch(error => {
        console.error('Error creating department:', error);
      });
  };
  
  const deleteDepartment = (id) => {
    axios.delete(`${baseURL}/departments/${id}`)
      .then(() => {
        fetchDepartments();
      })
      .catch(error => {
        console.error('Error deleting department:', error);
      });
  };
  
  onMounted(() => {
    fetchDepartments();
  });
  </script>
  