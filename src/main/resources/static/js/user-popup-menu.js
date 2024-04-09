function userPopupMenu() {
    return {
        show: false,
        toggleVisibility() {
            this.show = !this.show;
        },
        close() {
            this.show = false;
        },
        isVisible() {
            return this.show === true;
        },
        highlightMenuItem(event) {
            event.target.classList.add('font-bold'); // Додаємо жирний стиль
            event.target.classList.add('bg-gray-200'); // Змінюємо фон на темніший
        },
        resetMenuItem(event) {
            event.target.classList.remove('font-bold'); // Видаляємо жирний стиль
            event.target.classList.remove('bg-gray-200'); // Відновлюємо оригінальний фон
        }
    };
}