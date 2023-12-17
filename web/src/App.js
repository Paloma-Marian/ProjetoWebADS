import logo from './logo.svg';
import './App.css';
import {Link, Outlet} from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <div>
        <hr>
        <nav>
          <Link to='/alunos/cadastroAluno'>CadastroAluno</Link>
        </nav>
        </hr>
      </div>
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Trabalho final Web ADS
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
