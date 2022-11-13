$(function () {
    const searchParams = new URLSearchParams(window.location.search);
    if (searchParams.has('error')) {
        showToast('Đăng nhập thất bại.', 'Tài khoản hoặc mật khẩu không đúng.');
    } else if (searchParams.has('logout')) {
        sessionStorage.clear();
        showToast('Đăng xuất thành công.', 'Cảm ơn bạn đã sử dụng dịch vụ của chúng tôi.');
    }
});

function showToast(title, body) {
    $('#toast-title').text(title);
    $('#toast-body').text(body);
    bootstrap.Toast.getOrCreateInstance($('#toast')).show();
}
