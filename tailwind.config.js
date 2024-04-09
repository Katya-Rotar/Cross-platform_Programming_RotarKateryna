/** @type {import('tailwindcss').Config} */
const defaultTheme= require('tailwindcss/defaultTheme');
module.exports = {
  content: ['./src/main/resources/templates/**/*.html',
    './src/main/resources/templates/**/*.svg'],
  theme: {
    extend: {
      colors: {
        'demo-green': 'darkseagreen'
      },
      fontFamily: {
        sans: ['Inter var', ...defaultTheme.fontFamily.sans],
      },
      plugins: [
        require('@tailwindcss/forms')
      ],
    },
  },
  plugins: [require('@tailwindcss/container-queries'),require('daisyui'),require('@tailwindcss/forms'),require('@tailwindcss/typography')],
}