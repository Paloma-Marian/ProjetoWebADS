import { Link } from 'react-router-dom'

export default function BuscaAluno(mostra){
    function Excluir(){
        fetch(`http://localhost:8080/alunos/${mostra.aluno.id}`,
        {
            method: 'DELETE',
        })
        .then(aluno => alert('Aluno excluído com sucesso!'))
    }

    return(
        <div className='container'>
            <div className="card border-primary mb-3 col-md-6 offset-md-3">
                <img src='https://news.comschool.com.br/wp-content/uploads/2020/02/vaga-programador-front-end.jpg'className='card-img-top' alt='...' />
                <div className="text-center card-header">
                        <span>Nome:</span>
                        <span>{mostra.aluno.nome}</span>
                    </div>
                <div className='card-body text-primary'>
                    <div className='card-text'>
                        <span>CPF:</span>
                        <span>{mostra.aluno.cpf}</span>
                    </div>
                    <div className='card-text'>
                        <span>Email:</span>
                        <span>{mostra.aluno.email}</span>
                    </div>
                    <div className='card-text'>
                        <span>Status:</span>
                        <span>{mostra.aluno.status}</span>
                    </div>

                    <div className="d-grid gap-2 col-6 mx-auto">
                        <Link to={`/alunos/editar/${mostra.aluno.id}`}>
                            <button
                              className="btn btn-outline-primary fw-bold"
                            >Editar</button>
                        </Link>
                        <button
                            onClick={Excluir}
                            className="btn btn-outline-primary fw-bold"
                        >Excluir</button>
                    </div>
                </div>
            </div>
        </div>
    )
}
