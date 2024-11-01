function switchForm(formId) {
    // Ẩn tất cả các form
    const forms = document.querySelectorAll('form');
    forms.forEach(form => form.classList.remove('active'));

    // Hiển thị form được chọn
    const selectedForm = document.getElementById(formId);
    selectedForm.classList.add('active');
}
