/** @type {import('tailwindcss').Config} */
module.exports = {
  darkMode: 'class',
  content: ["./src/**/*.{xhtml,js,jsp}"],
  theme: {
    extend: {
      fontFamily: {
        'papyrus': ['Papyrus', 'sans-serif']
      },
      height: {
        '104': '25rem',
      },
      backgroundColor: {
        'custom-dark': '#2B2A33',
      },
      ringColor: {
        'custom-dark': '#2B2A33',
      },
    }
  },
  plugins: [],
}