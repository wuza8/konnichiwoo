import proxy from 'koa-proxies';
import { startDevServer } from '@web/dev-server';

export default {
  port: 8000,
  middleware: [
    proxy('/api', {
      target: 'http://localhost:8081',
    }),
  ],
  rootDir: process.cwd() + '/src',
};
