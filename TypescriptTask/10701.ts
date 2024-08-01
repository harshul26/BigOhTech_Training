const componentOption = {
  button: [
    {
      title: "Button Primary",
      image: "/assets/buttonV1.png",
      variant: "ButtonV1",
    },
    {
      title: "Button Secondary",
      image: "/assets/buttonV2.png",
      variant: "ButtonV2",
    },
    {
      title: "Button Tertiary",
      image: "/assets/buttonV3.png",
      variant: "ButtonV3",
    },
  ],
  header: [
    {
      title: "Header Primary",
      image: "/assets/headerV1.png",
      variant: "HeaderV1",
    },
    {
      title: "Header Secondary",
      image: "/assets/headerV2.png",
      variant: "HeaderV2",
    },
  ],
} as const; // making array readonly

const USER =  {
  button: [
    {
      image: "/assets/buttonV1.png",
      variant: "ButtonV1",
    },
    {
      image: "/assets/buttonV2.png",
      variant: "ButtonV2",
    },
    {
      image: "/assets/buttonV3.png",
      variant: "ButtonV3",
    },
  ],
  header: [
    {
      image: "/assets/headerV1.png",
      variant: "HeaderV1",
    },
    {
      image: "/assets/headerV2.png",
      variant: 8,
    
    },
  ],

} as const;

type ExtractVariant<T , P extends keyof T> = T[P] extends readonly {image : infer V}[] ? V : never;

type HeaderVariant = ExtractVariant<typeof componentOption , 'header'>;
type ButtonVariant = ExtractVariant<typeof componentOption , "button">;

type HeaderVariantUser = ExtractVariant<typeof USER, 'header'>

