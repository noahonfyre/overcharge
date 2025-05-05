import { defineConfig } from "vitepress"

// https://vitepress.dev/reference/site-config
export default defineConfig({
  title: "Overcharge Docs",
  description: "A VitePress Site",
  srcDir: "src",
  cleanUrls: true,
  markdown: {
    theme: {
      light: "catppuccin-latte",
      dark: "catppuccin-mocha",
    },
  },
  themeConfig: {
    // https://vitepress.dev/reference/default-theme-config
    logo: {
      src: "https://github.com/catppuccin/catppuccin/blob/main/assets/logos/exports/1544x1544_circle.png?raw=true",
      alt: "Overcharge Logo",
    },
    nav: [
      { text: "Home", link: "/" },
      { text: "Getting Started", link: "/getting-started/overview" },
    ],

    sidebar: [
      {
        text: "Getting Started",
        items: [
          { text: "Overview", link: "/getting-started/overview" },
          { text: "Installation", link: "/getting-started/installation" },
          { text: "Overview", link: "/getting-started/overview" }
        ]
      }
    ],

    socialLinks: [
      { icon: "discord", link: "https://dsc.gg/nyronium" },
      { icon: "github", link: "https://github.com/noahzeisberg/overcharge" }
    ]
  }
})
