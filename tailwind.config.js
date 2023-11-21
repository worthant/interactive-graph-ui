/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{xhtml,js,jsp}"],
  theme: {
    extend: {
      fontFamily: {
        'papyrus': ['Papyrus', 'sans-serif']
      },
      height: {
        '104': '25rem',
      }
    }
  },
  plugins: [],
}