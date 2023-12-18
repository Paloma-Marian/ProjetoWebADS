import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { RouterProvider, createBrowserRouter } from 'react-router-dom';

import CadastroAluno from './Aluno/cadastroAluno';
import ConsultaAluno from './Aluno/consultaAluno';
import AlterarAluno from './Aluno/alteraAluno';

import CadastroMateria from './Materia/cadastroMateria';

import CadastroTurma from './Turma/cadastroTurma';

const rotas = createBrowserRouter([
  {
    path:"/",
    element: <App/>,
    children:[
      {
        path: "/alunos/cadastroAluno",
        element: <CadastroAluno/>,
      },
      {
        path: "/alunos/consultaAluno",
        element: <ConsultaAluno/>,
      },  
      {
        path : "/alunos/alterar/:id_aluno",
        element: <AlterarAluno/>,
      },
      {
        path: "/alunos/cadastroMateria",
        element: <CadastroMateria/>,
      },
      {
        path: "/alunos/cadastroTurma",
        element: <CadastroTurma/>,
      },
    ]
  }
])

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <RouterProvider router={rotas}/>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
