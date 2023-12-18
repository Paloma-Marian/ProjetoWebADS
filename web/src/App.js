import logo from './logo.svg';
import './App.css';
import {Link, Outlet} from 'react-router-dom';

function App() {
  return (
    <div className="App" id="grad1">
      <div >
        <hr/>
        <nav>
          <Link to='/alunos/cadastroAluno'>Cadastro Aluno</Link>
          <Link to='/alunos/cadastroMateria'>Cadastro Materia</Link>
          <Link to='/alunos/cadastroTurma'>Cadastro Turma</Link>
        </nav>
        <main>
          <Outlet/>
        </main>
      </div>
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Trabalho final Web ADS
        </p>
      </header>
    </div>
  );
}

export default App;
