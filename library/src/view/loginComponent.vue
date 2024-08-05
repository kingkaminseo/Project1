<template>
    <div class="form-container">
        <form class="signup-form" @submit.prevent="registerUser">
            <h1>로그인</h1>
            <label for="email">아이디</label>
            <input type="email" v-model="user.email" id="email" name="email" placeholder="이메일을 입력하세요">
            
            <label for="password">비밀번호</label>
            <input type="password" v-model="user.password" id="password" name="password" placeholder="비밀번호를 입력하세요">
            
            <button type="submit">로그인</button>
        </form>
    </div>
</template>

<script setup>
import {ref} from 'vue';
import axios from 'axios';

const user = ref({
    email: '',
    password: '',
});

const registerUser = async () => {
  try {
    const response = await axios.post('http://localhost:8080/api/login', user.value, {
      headers: {
        'Content-Type': 'application/json'
      }
    });

    console.log(response.data);
    alert(response.data);
  } catch (error) {
    console.error('로그인 실패:', error);
    alert('로그인 실패');
  }
};

</script>

<style scoped>
.form-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 80vh;
    background-color: #f9f9f9;
    margin: 0;
}

.signup-form {
    background-color: #fff;
    padding: 20px 30px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    display: flex;
    flex-direction: column;
    gap: 15px;
    width: 100%;
    max-width: 700px;
}

.signup-form h1 {
    font-size: 24px;
    text-align: center;
    margin-bottom: 10px;
    color: #333;
}

.signup-form label {
    font-size: 14px;
    color: #333;
}

.signup-form input {
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 14px;
    width: 97%;
    margin-bottom: 10px;
}

.signup-form button {
    padding: 12px;
    border: none;
    border-radius: 4px;
    background-color: #007bff;
    color: white;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.signup-form button:hover {
    background-color: #0056b3;
}
</style>
