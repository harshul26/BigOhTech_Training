const routes = [{
        name: 'M1',
        comp: 'C1',
    },
    {
        name: 'M2',
        comp: 'C2',
    },
    {
        name: 'M3',
        subComp: [{
                name: 'M3A',
                comp: 'C3A',
            },
            {
                name: 'M3B',
                comp: 'C3B',
            },
        ],
    },
    {
        name: 'M4',
        subComp: [{
                name: 'M4A',
                comp: 'C4A',
            },
            {
                name: 'M4B',
                comp: 'C4B',
            },
        ],
    },
    {
        name: 'M5',
        subComp: [{
                name: 'M5A',
                comp: 'C5A',
            },
            {
                name: 'M5B',
                subComp: [{
                        name: 'M5BA',
                        comp: 'C5BA',
                    },
                    {
                        name: 'M5BB',
                        comp: 'C5BB',
                    },
                    {
                        name: 'M5BC',
                        comp: 'C5BC',
                    },
                ],
            },
            {
                name: 'M5C',
                comp: 'C5C',
            },
        ],
    },
];

const subscription = [{
        name: 'M1',
        isSub: true,
    },
    {
        name: 'M2',
        isSub: false,
    },
    {
        name: 'M3',
        isSub: false,
        subMod: [{
                name: 'M3A',
                isSub: true,
            },
            {
                name: 'M3B',
                isSub: true,
            },
        ],
    },
    {
        name: 'M4',
        isSub: true,
        subMod: [{
                name: 'M4A',
                isSub: false,
            },
            {
                name: 'M4B',
                isSub: true,
            },
        ],
    },
    {
        name: 'M5',
        isSub: true,
        subMod: [{
                name: 'M5A',
                isSub: false,
            },
            {
                name: 'M5B',
                isSub: true,
                subComp: [{
                        name: 'M5BA',
                        isSub: false,
                    },
                    {
                        name: 'M5BB',
                        isSub: true,
                    },
                    {
                        name: 'M5BC',
                        isSub: false,
                    },
                ],
            },
            {
                name: 'M5C',
                isSub: true,
            },
        ],
    },
];

function findSubscription(name, subscriptionList) {
    return subscriptionList.find(sub => sub.name === name);
}

function mainProcessingOfRoutes(routes, subscription) {
    console.log(routes);

    let firstSubscribedRoute = null;

    function processRoute(route, subscriptionList) {
        const subscribed = findSubscription(route.name, subscriptionList);

        if (!subscribed || !subscribed.isSub) {
            route.comp = 'UN';
            if (route.subComp) {
                route.subComp = route.subComp.map(subModule => ({
                    ...subModule,
                    comp: 'UN',
                }));
            }
        } else {
            if (!firstSubscribedRoute) {
                firstSubscribedRoute = route.name;
            }
            if (route.subComp !== null) {
                let subResult = mainProcessingOfRoutes(route["subComp"], subscribed["subMod"]);
                route.subComp = subResult;
                // route.subComp = route.subComp.map(subRoute =>
                //     processRoute(subRoute, subscribed.subMod || [])
                // );
            }
        }
        return route;
    }

    const processedRoutes = routes.map(route => processRoute(route, subscription));

    return [{
            redirectTo: firstSubscribedRoute,
        },
        ...processedRoutes
    ];
}

const result = mainProcessingOfRoutes(routes, subscription);
console.log(JSON.stringify(result, null, 2));
