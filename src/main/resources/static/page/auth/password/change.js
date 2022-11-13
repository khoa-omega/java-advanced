function changePassword() {
    $.ajax({
        method: 'PUT',
        url: 'http://localhost:8080/api/v1/auth/change',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify({
            username: sessionStorage.getItem('username'),
            password: $('#password').val()
        }),
        success: () => {
            showToast(
                'Đổi mật khẩu thành công.',
                'Chúng tôi đang chuyển hướng bạn đến trang chủ...'
            );
            setTimeout(() => location.replace('/index.html'), 2000);
        },
        error: () => showToast('Đổi mật khẩu thất bại.', 'Vui lòng thử lại.')
    });
}

function showToast(title, body) {
    $('#toast-title').text(title);
    $('#toast-body').text(body);
    bootstrap.Toast.getOrCreateInstance($('#toast')).show();
}
