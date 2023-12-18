import logo from './logo.svg';
import './App.css';
import {Link, Outlet} from 'react-router-dom';

function App() {
  return (
    <div className="App" id="grad1">
      <div >
        <hr/>
        <nav>
          <Link to='/alunos/cadastroAluno'>CadastroAluno</Link>
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
