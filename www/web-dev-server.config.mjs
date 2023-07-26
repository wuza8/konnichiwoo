import proxy from 'koa-proxies';
import { startDevServer } from '@web/dev-server';

export default {
  port: 8000,
  middleware: [
    proxy('/api', {
      target: 'http://localhost:8080',
    }),
  ],
  rootDir: process.cwd() + '/src',
};
