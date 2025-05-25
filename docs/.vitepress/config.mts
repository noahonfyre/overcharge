import { defineConfig } from "vitepress"

// https://vitepress.dev/reference/site-config
export default defineConfig({
  title: "Overcharge Docs",
  description: "A VitePress Site",
  srcDir: "src",
  cleanUrls: true,
  themeConfig: {
    // https://vitepress.dev/reference/default-theme-config
    logo: {
      src: "data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' fill='none' viewBox='0 0 24 24' stroke-width='1.5' stroke='white' class='size-6'%3E%3Cpath stroke-linecap='round' stroke-linejoin='round' d='M12 6.042A8.967 8.967 0 0 0 6 3.75c-1.052 0-2.062.18-3 .512v14.25A8.987 8.987 0 0 1 6 18c2.305 0 4.408.867 6 2.292m0-14.25a8.966 8.966 0 0 1 6-2.292c1.052 0 2.062.18 3 .512v14.25A8.987 8.987 0 0 0 18 18a8.967 8.967 0 0 0-6 2.292m0-14.25v14.25' /%3E%3C/svg%3E",
      alt: "Overcharge Logo",
    },
    nav: [
      { text: "Home", link: "/" },
      { text: "Documentation", link: "/getting-started/overview" },
      {
        text: "Getting Started",
        items: [
          { text: "Overview", link: "/getting-started/overview" },
          { text: "Installation", link: "/getting-started/installation" }
        ]
      }
    ],

    sidebar: [
      {
        text: "Getting Started",
        items: [
          { text: "Overview", link: "/getting-started/overview" },
          { text: "Installation", link: "/getting-started/installation" },
          { text: "Why Create?", link: "/getting-started/why-create" },
          { text: "Early Game", link: "/getting-started/early-game" },
        ]
      },
    ],

    socialLinks: [
      { icon: "discord", link: "https://dsc.gg/nyronium" },
      { icon: "github", link: "https://github.com/noahzeisberg/overcharge" }
    ]
  }
})
