$(document).ready(function() {
	$("#form").validate({
		lang: 'pt',
		rules: {
			nome: {
				required: true,
				maxlength: 50
			},
			email: {
				required: true,
				email: true,
				maxlength: 60
			}
		},
		messages: {
			nome: {
				required: 'O campo é obrigatório.',
				maxlength: 'Valor maior que o permitido.'
			},
			email:{
				required: 'O campo é obrigatório.',
				maxlength: 'Valor maior que o permitido.',
				email: 'E-mail inválido.'
			}
		}
	});
});

function iniciarVotacao() {
	$("#form").submit();
}

function escolherLivro(livro) {
	$("#votoAtual").val(livro);
	$("#form").submit();
}