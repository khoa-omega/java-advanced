$(function () {
    if ('username' in sessionStorage) {
        $('#btn-login').hide();
        $('#profile').show();
        $('.full-name').text(sessionStorage.getItem('fullName'));
    } else {
        $('#btn-login').show();
        $('#profile').hide();
    }

    // Load text by language
    $('#btn-search').append(_.header_search);
    $('#input-search').attr('placeholder', _.header_search);
    $('#btn-change-password').append(_.header_change_password);
    $('#btn-logout').append(_.header_logout);
    $('#btn-login').append(_.header_login);
    $('#btn-language').append(_.header_language);
});

function changeLanguage(code) {
    sessionStorage.setItem('language', code);
    window.location.reload();
}
